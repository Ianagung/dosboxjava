package dosbox.command.library;

import dosbox.filesystem.Directory;
import dosbox.interfaces.IDrive;
import dosbox.interfaces.IOutputter;
import dosbox.command.framework.Command;
import java.util.Date;

public class CmdTime extends Command{
    private static final String SYSTEM_CANNOT_FIND_THE_PATH_SPECIFIED = "File Not Found"; 
    private Directory directoryToPrint;
    private Date tanggal;

    public CmdTime(String name, IDrive drive) {
        super(name, drive);
    }
	@Override
	public boolean checkNumberOfParameters(int numberOfParametersEntered) {
//                System.out.println("jumlah parameter = " +numberOfParametersEntered);
		return (numberOfParametersEntered == 0 || numberOfParametersEntered == 1); 
	}
	
	@Override
	public boolean checkParameterValues(IOutputter outputter) {
        if(getParameterCount() == 1) {
//            this.destinationDirectory = extractAndCheckIfValidDirectory(this.getParameterAt(0), this.getDrive(), outputter);
//            return this.destinationDirectory != null;
//                System.out.println("jumlah parameter benar");
            System.out.println("parameter cuman 1");
            checkparam(this.getParameterAt(0), outputter);
        	return true;
        }
        else if(getParameterCount() == 0 )
        {
            tanggal = new Date();
            outputter.printLine("Tanggal sekarang adalah " + tanggal);
            return true;
        }
        else    
        {
//            this.destinationDirectory = null;
            return false;
        }
	}
	
	@Override
    public void execute(IOutputter outputter) {
        if (getParameterCount() == 0)
        {
//            printCurrentDirectoryPath(this.getDrive().getCurrentDirectory().getPath(), outputter);
        }
        else
        {
//            changeCurrentDirectory(this.destinationDirectory, this.getDrive(), outputter);
        }
    }
    
    public void checkparam(String paramstr, IOutputter outputter){
        if(paramstr.equals("gaga"))
            outputter.printLine("error gan, data salah banget");
//        System.out.println(paramstr);
    }
}
