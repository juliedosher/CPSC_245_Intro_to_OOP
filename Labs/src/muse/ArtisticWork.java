/*
 * The abstract class that defines ArtisticWork
 */

package muse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public abstract class ArtisticWork implements Serializable {
    private String creator;
    private String date;
    private String title;
    private String description;
    private ArrayList<Comment> comments;
   
    
    public String getCreator() {															// getters and setters
        return creator;
    }
    public void setCreator(String creator) {									
        this.creator = creator;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
    public ArrayList<Comment> getComments() {
    	return comments;
    }
    
    public void setComments(ArrayList<Comment> comments) {
    	this.comments = comments;
    }
    
    public ArtisticWork() {																	// default constructor
        date = "1/1/1900";
        title = "title";
        creator = "anonymous";
        description = "description";
        comments = new ArrayList<Comment>();
    }
    public ArtisticWork(String creator, String date, String title, String description) {	// constructor using individual data members
        setCreator(creator);																
        setDate(date);
        setTitle(title);
        setDescription(description);
        comments = new ArrayList<Comment>();
    }
    public ArtisticWork(LinkedHashMap<String,String> settings) {							// constructor using Linked Hash Map of data
        this(settings.get("creator"),settings.get("date"),settings.get("title"),settings.get("description"));
    }
    public abstract String getType();
   
    public String getGeneralInfoString() {
        return String.format("%s, a %s by %s, posted on %s",title,getType(),creator,date);
    }
 
    public abstract String getSpecificInfoString();
    
    public String getCommentsAsString() {
        String result = "";
        for (Comment comment : comments) {
            result = result + comment + "\n";
        }
        if (result.isBlank()) {
            return "No comments";
        }
        return result;
    }
    @Override
    public String toString() {
        return getGeneralInfoString() + "\n" + getSpecificInfoString() + "\nComments: \n" + getCommentsAsString();
    }
    
  
    public abstract String toTabbedString();
    
    
    public void addComment(String postedBy, String date, String content) {					// adds comment to work
        Comment comment = new Comment(postedBy, date, content);
        comments.add(comment);
    }
    
    public void addComment(Comment comment) {												// adds just a comment without author and date info
        comments.add(comment);
    }
    
    public String getShortString() {
        return String.format("\"%s\", a %s by %s", title, getType(), creator);
    }
}
