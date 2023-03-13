package org.bg181.ms.nacos.note;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 笔记
 *
 * @author lxc
 * @date 2023/03/11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Note {

    private Long id;

    private String title;

    private String content;

    private String userId;

    private String userNickname;

}
