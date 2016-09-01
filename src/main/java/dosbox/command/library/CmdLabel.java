/*
 * DOSBox, Scrum.org, Professional Scrum Developer Training
 * Authors: Rainer Grau, Daniel Tobler, Zuehlke Technology Group
 * Copyright (c) 2013 All Right Reserved
 */ 

package dosbox.command.library;

import java.io.Console;
import java.io.IOException;
import java.util.Scanner;

import dosbox.command.framework.Command;
import dosbox.filesystem.Directory;
import dosbox.filesystem.FileSystemItem;
import dosbox.interfaces.IDrive;
import dosbox.interfaces.IOutputter;

/**Command to change current directory.
 * Example for a command with optional parameters.
 */
class CmdLabel extends Command {
	
	protected CmdLabel(String name, IDrive drive) {
		super(name, drive);
	}

	@Override
	public boolean checkNumberOfParameters(int numberOfParametersEntered) {
         
		return (numberOfParametersEntered == 0 || numberOfParametersEntered == 1); 
	}
	
	@Override
	public boolean checkParameterValues(IOutputter outputter) {
        if(getParameterCount() > 0) {

            return true;
        }
        else
        {
            //this.destinationDirectory = null;
            return true;
        }
	}
	
	@Override
    public void execute(IOutputter outputter) {
        String vlabel;
		if (getParameterCount() == 0)
        {
        	int readChar = 0;
        	StringBuilder input = new StringBuilder();
        	String line = new String();
        	
        	outputter.print("Volume label (32 characters, ENTER for none)? ");
			try {
				while (readChar != '\n') {
					readChar = System.in.read();
					input.append((char)readChar);
				}
				line = input.toString();
			} catch (IOException e) {
				// do nothing by intention
			}
			if (line.isEmpty() || line.equals("")) {
				vlabel="";
			}
        }
        changeLabel(this.getParameterAt(0), this.getDrive(), outputter);
        
    }

    private static void changeLabel(String label, IDrive drive, IOutputter outputter) {
    	drive.setLabel(label+" ");
        //outputter.printLine("ganti");
    }
//
//    private static void printCurrentDirectoryPath(String currentDirectoryName, IOutputter outputter) {
//        outputter.printLine(currentDirectoryName);
//    }
//
//    private static Directory extractAndCheckIfValidDirectory(String destinationDirectoryName, IDrive drive, IOutputter outputter) {
//        FileSystemItem tempDestinationDirectory = drive.getItemFromPath(destinationDirectoryName);
//        if (tempDestinationDirectory == null)
//        {
//            outputter.printLine(SYSTEM_CANNOT_FIND_THE_PATH_SPECIFIED);
//            return null;
//        }
//        if (!tempDestinationDirectory.isDirectory())
//        {
//            outputter.printLine(DESTINATION_IS_FILE);
//            return null;
//        }
//        return (Directory)tempDestinationDirectory;
//    }
}
