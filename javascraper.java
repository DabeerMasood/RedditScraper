

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import java.io.*;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;

import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class javascraper{

public static void main (String[]args) throws MalformedURLException
{
	Scanner scan = new Scanner (System.in);
	System.out.println("Where do you want to store the files?");
	String folderpath = scan.next();
	System.out.println("What subreddit do you want to scrape?");
	String subreddit = scan.next();
	subreddit = ("http://reddit.com/r/" + subreddit);
	new File(folderpath + "/" + subreddit).mkdir();
	
//test

try{
    //gets http protocol
Document doc = Jsoup.connect(subreddit).timeout(0).get();

//get page title
String title = doc.title();
System.out.println("title : " + title);

//get all links
Elements links = doc.select("a[href]");

for(Element link : links){

//get value from href attribute
String checkLink = link.attr("href");
Elements images = doc.select("img[src~=(?i)\\.(png|jpe?g|gif)]");
if (imgCheck(checkLink)){ // checks to see if img link j
    System.out.println("link : " + link.attr("href"));
downloadImages(checkLink, folderpath);





}
}



}
catch (IOException e){
e.printStackTrace();
}

}


public static boolean imgCheck(String http){
String png = ".png";
String jpg = ".jpg";
String jpeg = "jpeg"; // no period so checker will only check last four characaters
String gif = ".gif";
int length = http.length();

if (http.contains(png)|| http.contains("gfycat") || http.contains(jpg)|| http.contains(jpeg) || http.contains(gif)){
return true;
}
else{
return false;
}



}



private static void downloadImages(String src, String folderpath) throws IOException{
String folder = null;

        //Exctract the name of the image from the src attribute

        int indexname = src.lastIndexOf("/");

        if (indexname == src.length()) {

            src = src.substring(1, indexname);

        }
 indexname = src.lastIndexOf("/");

        String name = src.substring(indexname, src.length());

        System.out.println(name);

        //Open a URL Stream

        URL url = new URL(src);

        InputStream in = url.openStream();

        OutputStream out = new BufferedOutputStream(new FileOutputStream( folderpath+ name));

 

        for (int b; (b = in.read()) != -1;) {

            out.write(b);

        }

        out.close();

        in.close();

 




}



}





