package robot.operation.event;


public class MouseRelease  extends AMousePRC{

	public MouseRelease(){
		flag="NATIVE_MOUSE_RELEASED";
	}
	@Override
	public boolean consume(String msg) throws Exception {
		super.consume(msg);
		robot.mouseRelease(buttonMapping(button));
//		pause(200);
		return true;
	}

}
