/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codefornature;

/**
 *
 * @author SCSM11
 */

import java.io.BufferedReader;
import java.io.File;

import java.io.FileReader;
import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class NewsFilter {
     public static List<NewsArticle> readNewsFromFile(String filePath) {
        List<NewsArticle> newsList = new ArrayList<>();

        // Check if the file exists
        File file = new File(filePath);
        if (!file.exists()) {
            System.err.println("File not found: " + filePath);
            return newsList;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String title = line.trim();
                String url = br.readLine().trim();
                String dateString = br.readLine().trim();
                br.readLine();
                Date date = parseDate(dateString);

                newsList.add(new NewsArticle(title, url, date));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return newsList;
    }
private static Date parseDate(String dateString) {
    try {
        if (dateString != null && !dateString.trim().isEmpty()) {
            if (dateString.startsWith("https//")) {
                System.err.println("URL found: " + dateString);
                return null;
            } else {
                return new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH).parse(dateString);
            }
        } else {
            // If the date string is empty, return null or handle it as needed
            return null;
        }
    } catch (ParseException e) {
        System.err.println("Error parsing date: " + dateString);
        e.printStackTrace();  // Print the full stack trace for debugging
        return null;
    }
}
    
public static List<NewsArticle> filterNews(List<NewsArticle> newsList, String keyword) {
    System.out.println("Filtering news with keyword: " + keyword);
    
    List<NewsArticle> filteredList = newsList.stream()
            .filter(news -> news.title.toLowerCase().contains(keyword.toLowerCase()))
            .sorted(Comparator.comparing(NewsArticle::getDate).reversed())
            .collect(Collectors.toList());

    System.out.println("Filtered articles count: " + filteredList.size());
    return filteredList;
}
// Modify getTop5News method to get the top 5 news
    public static List<NewsArticle> getTop5News(List<NewsArticle> newsList) {
        return newsList.stream()
                .limit(5)
                .collect(Collectors.toList());
    }
    



    static class NewsArticle {
        String title;
        String url;
        Date date;

        NewsArticle(String title, String url, Date date) {
            this.title = title;
            this.url = url;
            this.date = date;
        }

        Date getDate() {
            return date;
        }
    }
}
