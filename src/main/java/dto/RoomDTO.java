package dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RoomDTO {
    private String room_type_id;
    private String type;
    private Double key_money;
    private String qty;
}
