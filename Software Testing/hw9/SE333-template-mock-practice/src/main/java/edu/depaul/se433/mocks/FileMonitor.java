package edu.depaul.se433.mocks;

import java.util.List;

/**
 * The job of the file monitor is to monitor a given directory
 * and when it finds temp files (*.tmp) in that directory, it deletes
 * them.  It performs this work with the aid of a FileService
 */
public class FileMonitor {
	
	private FileService fileService;
	
	public FileMonitor(FileService s) {
		fileService = s;
	}
	
	public void clean(String path) {
		List<String> files = fileService.getDirectoryContents(path);
		
		for (String name : files) {
			if (name.endsWith(".tmp")) {
				fileService.delete(name);
			}
		}
	}

}
