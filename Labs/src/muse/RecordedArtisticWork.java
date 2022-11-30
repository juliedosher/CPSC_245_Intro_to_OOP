/*
 * The abstract class that defines RecordedArtisticWork, inherited from ArtisticWork
 */


package muse;

import java.util.LinkedHashMap;

public abstract class RecordedArtisticWork extends ArtisticWork {
    private int duration; // in seconds
    private String fileName;
    private double fileSize;
    public int getDuration() {
        return duration;
    }
    public void setDuration(int seconds) {											// getters and setters:
        if (seconds < 0) {
            duration = 0;
        } else {
            duration = seconds;
        }
    }
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fname) {
        fileName = fname;
    }
    public double getFileSize() {
        return fileSize;
    }
    public void setFileSize(double fsize) {
        if (fsize < 0) {
            fileSize = 0;
        } else {
            fileSize = fsize;
        }
    }
    public RecordedArtisticWork() {													// default constructor
        fileName = "";
        fileSize = 0;
        duration = 0;
    }
    public RecordedArtisticWork(String creator, String date, String title, 			// constructor using individual data members
    		String description, int duration, String fileName, double fileSize) {
        super(creator,date,title,description);
        setDuration(duration);
        setFileName(fileName);
        setFileSize(fileSize);
    }
    public RecordedArtisticWork(LinkedHashMap<String,String> settings) {			// constructor using Linked Hash Map of data
        super(settings);
        setDuration(Integer.parseInt(settings.get("duration")));
        setFileName(settings.get("filename"));
        setFileSize(Double.parseDouble(settings.get("filesize")));
    }
    @Override
    public String getGeneralInfoString() {											// returns universal info for recorded works as a String
        return String.format("%s\nDuration: %d sec; Filename: %s (%.2f MB)", super.getGeneralInfoString(),
                duration, fileName, fileSize);
    }
    
    public abstract String toTabbedString();
}
