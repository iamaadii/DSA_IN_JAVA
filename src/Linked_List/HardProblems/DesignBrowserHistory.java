/*
You have a browser of one tab where you start on the homepageand you can visit another url, get back in the history number of
steps or move forward in the history number of steps.

Implement the BrowserHistory class:
    BrowserHistory(string homepage) Initializes the object with the homepage of the browser.

    void visit(string url) Visits url from the current page. It clears up all the forward history.

    string back(int steps) Move steps back in history. If you can only return x steps in the history and steps > x,
        you will return only x steps. Return the current url after moving back in history at most steps.

    string forward(int steps) Move steps forward in history. If you can only forward x steps in the history and steps > x,
     you will forward only x steps. Return the current url after forwarding in history at most steps.

Constraints:
    1 <= homepage.length <= 20
    1 <= url.length <= 20
    1 <= steps <= 100
    homepage and url consist of  '.' or lower case English letters.
    At most 5000 calls will be made to visit, back, and forward.

*/
package Linked_List.HardProblems;
class Nodee{
    String url;
    Nodee prev;
    Nodee next;

    Nodee(String homepage){
        this.url = homepage;
        this.prev = null;
        this.next = null;
    }
}
public class DesignBrowserHistory {
    Nodee current;

    DesignBrowserHistory(String homepage){
        current = new Nodee(homepage);
    }

    void visit(String url){
        Nodee newNode = new Nodee(url);
        current.next = newNode;
        newNode.prev = current;
        current = current.next;
    }

    String back(int steps){
        while (steps>0){
            if (current.prev != null) {
                current = current.prev;
                steps--;
            }
            else break;
        }
        return current.url;
    }

    String forward(int steps){
        while (steps>0){
            if (current.next != null) {
                current = current.next;
                steps--;
            }
            else break;
        }
        return current.url;
    }

    public static void main(String[] args) {
        DesignBrowserHistory d = new DesignBrowserHistory("gfg.org");
        d.visit("google.com");
        d.visit("facebook.com");
        System.out.println(d.forward(2));
    }
}
