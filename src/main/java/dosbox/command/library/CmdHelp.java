/*
 * DOSBox, Scrum.org, Professional Scrum Developer Training
 * Authors: Rainer Grau, Daniel Tobler, Zuehlke Technology Group
 * Copyright (c) 2013 All Right Reserved
 */ 

package dosbox.command.library;

import dosbox.command.framework.Command;
import dosbox.interfaces.IDrive;
import dosbox.interfaces.IOutputter;

/**Command to change current directory.
 * Example for a command with optional parameters.
 */
class CmdHelp extends Command {

	private static final String[] HELP_STRING = 
	{
	   "Error:   This command is not supported by the help utility.",
	   "CD       Displays the name of or changes the current directory.", 
	   "DIR      Displays a list of files and subdirectories in a directory.", 
	   "EXIT     Quits the CMD.EXE program (command interpreter).", 
	   "FORMAT   Formats a disk for use with Windows.",
	   "HELP     Provides Help information for Windows commands.", 
	   "LABEL    Creates, changes, or deletes the volume label of a disk.", 
	   "MKDIR    Creates a directory.", 
	   "MKFILE   Created a file.",
	   "MOVE     Moves one or more files from one directory to another directory."
    };

	protected CmdHelp(String name, IDrive drive) {
		super(name, drive);
	}

	@Override
	public boolean checkNumberOfParameters(int numberOfParametersEntered) {
		return (numberOfParametersEntered == 0 || numberOfParametersEntered == 1); 
	}
		
	@Override
    public void execute(IOutputter outputter) {
        if (getParameterCount() == 0)
        {
        	for (int i = 1; i < HELP_STRING.length; i++) {
        		outputter.printLine(HELP_STRING[i]);
        	}
        }
        else
        {
        	int helpIdx = 0;
        	switch (getParameterAt(0).toLowerCase())
        	{
	        	case "cd"		: helpIdx = 1; break;
	        	case "dir"		: helpIdx = 2; break;
	        	case "exit"		: helpIdx = 3; break;
	        	case "format"	: helpIdx = 4; break;
	        	case "help"		: helpIdx = 5; break;
	        	case "label"	: helpIdx = 6; break;
	        	case "mkdir"	: helpIdx = 7; break;
	        	case "mkfile"	: helpIdx = 8; break;
	        	case "move"		: helpIdx = 9; break;
        	}
        	outputter.printLine(HELP_STRING[helpIdx]);
        }
    }
}