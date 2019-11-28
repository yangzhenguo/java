package com.yangzg.hibernate.model5;

import lombok.*;

/**
 * Created by Sam on 2019/10/28.
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Wife {
    private Integer id;
    @NonNull
    private String name;
}
