package robot.enabler;

import java.io.IOException;
import java.util.Date;

import org.jnativehook.NativeHookException;

import utils.FileUtil;
import utils.LogUtil;

public class RobotEnabler extends ABasic{
	private static RobotEnabler instance;
	static{
		instance=new RobotEnabler();
	}
	Reappear reappear=new Reappear();
	
	public static void record(String filePath,long duration,long startWait){
		try {
			Thread.sleep(startWait);
			instance._record(filePath, duration);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void reappear(String filePath,long duration,long startWait) {
		try {
			Thread.sleep(startWait);
			instance._reappear(filePath, duration);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private  void _record(String filePath,long duration) throws IOException, InterruptedException, NativeHookException{
		path=filePath;
		FileUtil.createFile(path);
		listenHook();
		LogUtil.p("开始记录");
		recordStartTime=new Date();
//		long now=System.currentTimeMillis();
		sleep(duration);
		unListenHook();
		LogUtil.p("结束记录");
	}
	
	private void _reappear(String filePath,long duration) throws Exception{
		reappear.action(filePath, duration);
	}
	public static void main(String[] args) {
//		record("e:/record1.txt",5000);
		reappear("e:/record1.txt",5000,0);
	}
}
