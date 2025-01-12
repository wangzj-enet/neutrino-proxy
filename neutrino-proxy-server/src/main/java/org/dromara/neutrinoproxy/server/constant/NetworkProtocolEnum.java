package org.dromara.neutrinoproxy.server.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: aoshiguchen
 * @date: 2023/4/2
 */
@Getter
@AllArgsConstructor
public enum NetworkProtocolEnum {
    TCP("TCP"),
    UDP("UDP"),
    HTTP("HTTP"),
    ;
    private String desc;
    private static final Map<String, NetworkProtocolEnum> map = Stream.of(NetworkProtocolEnum.values()).collect(Collectors.toMap(NetworkProtocolEnum::getDesc, Function.identity()));

    public static NetworkProtocolEnum of(String desc) {
        return map.get(desc);
    }
}
