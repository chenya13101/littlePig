package com.vincent.enums;

import com.vincent.enums.constant.SexEnum;

/**
 * 
 * 网络博文上的例子，提供了一个很好的思路 : EnumCommonInterface 让需要实现这个getEnumObject方法的。
 * 可以自由决定使用原来的枚举类中的某个属性作为主键.但是通过指定文件夹路径，初始化Constant类时初始枚举map,步骤有点多了
 * 
 * @author WenSen
 * @date 2018年8月3日 下午2:39:03
 *
 */
public class Main {
	public static void main(String[] args) {
		SexEnum e1 = EnumUtil.getEnumObject("M", SexEnum.class);
		System.out.println(e1);// MAN
	}

}
