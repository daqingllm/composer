//package me.hailu;
//
///*
// * MovieConverter.java
// * for transmediale QTJ workshop, February 2004
// * copyright (c) 2004 by Jason Freeman
// * relased under terms of the GNU public license
// * http://www.gnu.org/licenses/licenses.html#TOCGPL
// *
// * some portions based on work by:
// * (c) 2003, Chris Adamson, invalidname@mac.com
// * relased under terms of the GNU public license
// * http://www.gnu.org/licenses/licenses.html#TOCGPL
// *
// *
// * ABOUT THIS PROGRAM:
// * MovieConverter presents a dialog box allowing the user to select any media file recognized by Quicktime.
// * It then presents a second dialog box allowing the user to convert the media file to any format supported
// * by Quicktime and saves the converted file as a new file.
// */
//
//import quicktime.QTSession;
//import quicktime.io.IOConstants;
//import quicktime.io.OpenMovieFile;
//import quicktime.io.QTFile;
//import quicktime.std.StdQTConstants;
//import quicktime.std.movies.Movie;
//
//import java.awt.*;
//import java.io.File;
//
//public class MovieConverter extends Frame {
//
//    Movie movie; // basic Quicktime class for representing all types of media
//
//    public MovieConverter(String title) {
//        super(title);
//        try {
//            QTSession.open(); // initialize the Quicktime engine
//
//            FileDialog fd = new FileDialog(this, "Select source movie", FileDialog.LOAD);
//            fd.show();
//            if (fd.getFile() == null) return;
//            File f = new File(fd.getDirectory(), fd.getFile());
//
//            // open the media file with Quicktime
//            QTFile inputFile = new QTFile(f);
//            OpenMovieFile omFile = OpenMovieFile.asRead(inputFile);
//            movie = Movie.fromFile(omFile);
//
//            // show progress bar if conversion operation takes a long time
//            movie.setProgressProc();
//
//            // convert the movie into a new format and save it as a new file
//            //int exportType = StdQTConstants.kQTFileTypeMovie; // limit to exporting Quicktime Movies
//            int exportType = 0; // allow conversions to other movie formats and
//            movie.convertToFile(new QTFile("Export Movie"), // temporary name of movie which shows up in dialog box
//                    exportType, // allow conversion to any supported file type
//                    StdQTConstants.kMoviePlayer, // set the creator of the file
//                    // to be MoviePlayer
//                    IOConstants.smSystemScript, // what script movie should be
//                    // converted into
//                    StdQTConstants.showUserSettingsDialog); // show a dialog
//            // box to let user
//            // configure the
//            // details
//
//            // shut down the Quicktime engine
//            QTSession.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args) {
//        MovieConverter frame = new MovieConverter("QTJ Movie Converter");
//        System.exit(0);
//    }
//}