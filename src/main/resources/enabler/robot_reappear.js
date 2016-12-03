(function(request){
	var filePath=request.filePath;
	var duration=request.duration;
	var startWait=request.startWait;
	load("/lib/RobotUtil.js");
	RobotUtil.reappear(filePath,duration,startWait);
	$_response_$={
			c:"ok"
	}
})($_request_param_$)