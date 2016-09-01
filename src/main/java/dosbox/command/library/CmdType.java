/*
 * DOSBox, Scrum.org, Professional Scrum Developer Training
 * Authors: Rainer Grau, Daniel Tobler, Zuehlke Technology Group
 * Copyright (c) 2013 All Right Reserved
 */

package dosbox.command.library;

import dosbox.command.framework.Command;
import dosbox.filesystem.FileSystemItem;
import dosbox.interfaces.IDrive;
import dosbox.interfaces.IOutputter;

class CmdType extends Command {
	private static final String SYSTEM_CANNOT_FIND_THE_PATH_SPECIFIED = "The system cannot find the file specified";

	public CmdType(String name, IDrive drive) {
		super(name, drive);
	}

		@Override
	public void execute(IOutputter outputter) {
		FileSystemItem fsi = getDrive().getItemFromPath(getParameterAt(0));
		
		try {
			if (fsi.isDirectory()) {
				outputter.print("Access is denied.");
			} else {
				outputter.print("Isi dari file " + fsi.getName() + " adalah : ");
				outputter.print("\n" + fsi.getFileContent());
			}
			
			outputter.newLine();
		} catch (NullPointerException e) {
			outputter.printLine(SYSTEM_CANNOT_FIND_THE_PATH_SPECIFIED);
		} 
	}
}
