package fx.service;

import cn.kind.fx.ioc.annotation.AutoWire;
import cn.kind.fx.ioc.annotation.Component;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import fx.dto.MyUsb;
import fx.util.JavaScriptExe;
import javafx.application.Platform;
import javafx.scene.web.WebEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Auther yiliang
 * @Date 2020/9/1 11:26
 * @Description $
 */
@Component
public class UsbChangeListener {

	@AutoWire
	private JavaScriptExe javaScriptExe;

	@AutoWire
	private WebEngine webEngine;

	private ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);

	private List<MyUsb> usbList = new ArrayList<>();
	Integer ranNumber = 2014;
	//这里测试和 java调用javascript函数
	public UsbChangeListener(){

		Runnable r2 = () -> {
			MyUsb myUsb = new MyUsb();
			myUsb.setIcon("mdi-usb");
			myUsb.setTitle("Photos");
			myUsb.setSubtitle("Jan 9, "+ranNumber);
			ranNumber=ranNumber+1;
			usbList.add(myUsb);
			System.out.println("调用了");

			javaScriptExe.exe("changeUsb", JSONArray.toJSONString(usbList));
		};
		//每两秒执行一次
		scheduledThreadPool.scheduleAtFixedRate(r2, 5, 5, TimeUnit.SECONDS);

	}

}
