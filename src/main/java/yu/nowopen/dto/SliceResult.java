package yu.nowopen.dto;

import java.util.List;

public record SliceResult<T>(
        List<T> value,
        boolean hasNext
) {

}
