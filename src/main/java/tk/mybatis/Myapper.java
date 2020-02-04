package tk.mybatis;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 该接口不能 被扫描到否则报错
 * @param <T>
 */
public interface Myapper<T> extends Mapper<T>, MySqlMapper<T> {
}
