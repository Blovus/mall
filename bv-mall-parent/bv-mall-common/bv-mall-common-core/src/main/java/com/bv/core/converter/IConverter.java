package com.bv.core.converter;

import java.util.List;

/**
 * @ProjectName: mall
 * @Package: com.bv.core.utils
 * @ClassName: Constants
 * @Author: blovus
 * @Description: Convertor Convertor 接口转换类
 * @Date: 2019/5/7 22:57
 * @Version: 1.0
 */
public interface IConverter<A, B> {

	/**
	 * 把Service层的model转换为Dao层的model
	 * 
	 * @param source
	 * @return
	 * @throws Exception
	 */
	 B invert(A source) throws Exception;

	/**
	 * 把Dao层的model转换为Service层的model
	 * 
	 * @param source
	 * @return
	 * @throws Exception
	 */
	 A convert(B source) throws Exception;

	/**
	 * 把Service层的model list转换为Dao层的model list
	 * 
	 * @param source
	 * @return
	 * @throws Exception
	 */
	List<B> invertList(List<A> source) throws Exception;

	/**
	 * 把Dao层的model list转换为Service层的model list
	 * 
	 * @param source
	 * @return
	 * @throws Exception
	 */
	 List<A> convertList(List<B> source) throws Exception;

}
