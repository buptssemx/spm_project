/**
 * 
 */
package com.codeagles.util;

import java.util.UUID;

/**
 * <p>Title: UUIDUtils</p>
 * <p>@function:</p>
 * @author Codeagles   ,
 * @date ����7:02:11
 */
public class UUIDUtils {
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}
}
