package org.bg181.ms.nacos.note;

import lombok.Data;

/**
 * 笔记
 *
 * @author lxc
 * @date 2023/03/11
 */
@Data
public class Note {

    private Long id;

    private String title;

    private String content;

    private String userId;

    private String userNickname;

}
