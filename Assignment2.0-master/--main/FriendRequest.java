package YoungStudents;
import java.util.ArrayList;
import java.util.List;

public class FriendRequest  {
    private List<String> sentRequests;

    public FriendRequest(){
        this.sentRequests=new ArrayList<>();
    }

    public void sednFriendRequest(YoungStudent friend){//check if friend is already in the friend list or if request has been sent before
        if(this.friends.contains(friend.getUserName())){
            System.out.println("Friend is already in your friend list.");
        }
        else if(sentRequests.contains(friend.getUserName())){
            System.out.println("Friend request has already been sent to this user");
        }
        else{
            System.out.println("Friend request send to "+friend.getUserName());
        }
    }

    public void receiveFriendRequest(YoungStudent sender){//Receive and manage a friend request
        this.receivedRequests.add(sender.getUserName());
        System.out.println("Received friend request from: "+sender.getUserName());
    }

    public void acceptFriendRequest(String senderUsername){//Accept a friend request
        if(this.receivedRequests.contains(senderUsername)){
            this.friends.add(senderUsername);
            this.receivedRequests.remove(senderUsername);
            System.out.println("Friend request from "+senderUsername+" accepted.");
        }
    }
}
