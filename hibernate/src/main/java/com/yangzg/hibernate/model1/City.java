package com.yangzg.hibernate.model1;

import com.yangzg.hibernate.model1.embeddable.GPS;
import lombok.*;

/**
 * Created by Sam on 2019/10/26.
 */
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
public class City {
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private GPS coordinates;
}
