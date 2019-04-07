package com.example.continuity;

import android.os.AsyncTask;

import java.io.File;
import java.util.ArrayList;

public abstract class FilesList extends AsyncTask<String, Void, ArrayList<AvatarFile>> implements CallbackReceiver {

	@Override
	protected ArrayList<AvatarFile> doInBackground(String... params) {
		String path = params[0];
		ArrayList<AvatarFile> myFiles = new ArrayList<AvatarFile>();
		Utility utility = new Utility();
		File file = new File(path);
		//file.mkdirs();
		File[] files = file.listFiles();
	    if (files != null && files.length > 0) {
	    	for (int i = 0; i < files.length; i++) {
	        	String avatarHeading = files[i].getName();
	        	long lastModified = files[i].lastModified();
	        	String lastModifiedDate = utility.getDate(lastModified, "dd MMM yyyy hh:mm a");
	        	int icon = R.mipmap.folder;
	        	String itemsOrSize, filePath, type;
	        	if (files[i].isDirectory()) {
	        		type = "folder";
	        		File tempArray[] = files[i].listFiles();
	        		if (tempArray != null) {
	        			itemsOrSize = files[i].listFiles().length + " items";
	        		} else {
	        			itemsOrSize = 0 + " item";
	        		}
	        	} else {
	        		itemsOrSize = utility.getSize(files[i].length());
	        		type = "file";
	        		if (avatarHeading.length() > 3) {
	        			String extension = avatarHeading.substring(avatarHeading.length() - 3).toLowerCase();
	        			if (extension.equals("jpg") || extension.equals("jpeg") || extension.equals("png")
	        					|| extension.equals("svg")) {
	        				type = "image";
	        			} else if (extension.equals("mp3")) {
	        				type = "mp3";
	        			} else if (extension.equals("pdf")) {
	        				type = "pdf";
	        			}
	        		}
	        	}
	        	filePath = files[i].getAbsolutePath();
	        	String subHeading = itemsOrSize + " " + lastModifiedDate;
	        	AvatarFile avatarFile = new AvatarFile(
	        			icon, avatarHeading, subHeading, filePath, type);
	        	myFiles.add(avatarFile);
	        }
	    }
	    return myFiles;
	}

	protected void onPostExecute(ArrayList<AvatarFile> myFiles) {
		receiveData(myFiles);
	}

	@Override
	public abstract void receiveData(Object result);

}
