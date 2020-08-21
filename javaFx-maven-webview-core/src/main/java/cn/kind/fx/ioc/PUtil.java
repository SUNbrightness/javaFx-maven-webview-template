package cn.kind.fx.ioc;

/**
 * @Auther yiliang
 * @Date 2020/8/20 16:33
 * @Description $
 */
public class PUtil {
	public static String join(String src,String... str){
		StringBuffer stringBuffer = new StringBuffer(src);

		for (String s : str) {
			stringBuffer.append(".");
			stringBuffer.append(s);
		}
		return stringBuffer.toString();
	}
}
