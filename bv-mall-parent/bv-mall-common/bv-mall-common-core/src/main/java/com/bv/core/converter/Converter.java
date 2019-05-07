package com.bv.core.converter;

import java.util.LinkedList;
import java.util.List;

/**
 * @ProjectName: mall
 * @Package: com.bv.core.utils
 * @ClassName: Constants
 * @Author: blovus
 * @Description: Convertor 抽象转换类
 * @Date: 2019/5/7 22:57
 * @Version: 1.0
 */
public abstract class Converter<A, B> implements IConverter<A, B> {

	/**
	 * 把Service层的model转换为Dao层的model
	 * 
	 * @param source
	 * @return
	 * @throws Exception
	 */
	@Override
	public final B invert(A source) throws Exception {
		if (source == null) {
			return null;
		}
		return this.defaultInvert(source);
	}

	/**
	 * 把Dao层的model转换为Service层的model
	 * 
	 * @param source
	 * @return
	 * @throws Exception
	 */
	@Override
	public final A convert(B source) throws Exception {
		if (source == null) {
			return null;
		}
		return this.defaultConvert(source);
	}

	/**
	 * 把Service层的model list转换为Dao层的model list
	 * 
	 * @param sources
	 * @return
	 * @throws Exception
	 */
	@Override
	public final List<B> invertList(List<A> sources) throws Exception {
		return this.defaultInvertList(sources);
	}

	/**
	 * 把Dao层的model list转换为Service层的model list
	 * 
	 * @param sources
	 * @return
	 * @throws Exception
	 */
	@Override
	public final List<A> convertList(List<B> sources) throws Exception {
		return this.defaultConvertList(sources);
	}

	/**
	 * 把Service层的model list转换为Dao层的model list
	 * 
	 * @param sources
	 * @return
	 * @throws Exception
	 */
	protected List<B> defaultInvertList(List<A> sources) throws Exception {
		if (sources == null) {
			return null;
		}
		List<B> targets = new LinkedList<B>();
		for (A source : sources) {
			targets.add(this.invert(source));
		}

		return targets;
	}

	/**
	 * 把Service层的model list转换为Dao层的model list
	 * 
	 * @param sources
	 * @return
	 * @throws Exception
	 */
	protected List<A> defaultConvertList(List<B> sources) throws Exception {
		if (sources == null) {
			return null;
		}
		List<A> targets = new LinkedList<A>();
		for (B source : sources) {
			targets.add(this.convert(source));
		}

		return targets;
	}

	protected abstract B defaultInvert(A source) throws Exception;

	protected abstract A defaultConvert(B source) throws Exception;

}
