package com.sorhive.comprojectserver.room.command.domain.room;

import com.sorhive.comprojectserver.room.command.domain.guestbook.GuestBook;
import com.sorhive.comprojectserver.room.command.domain.roomvisit.RoomVisit;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <pre>
 * Class : Room
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-08       부시연           최초 생성
 * 2022-11-09       부시연           몽고 DB 도메인으로 변경
 * </pre>
 *
 * @author 부시연(최초 작성자)
 * @version 1(클래스 버전)
 */
@Getter
@Entity
@Table(name = "tbl_rooms")
public class Room {

    @Id
    @Column(name="room_id")
    private Long id;

    private RoomCreator roomCreator;

    @Column(name="room_no")
    private String roomNo;

    @Column(name = "room_count")
    @ColumnDefault("0")
    private Long roomCount;

    @Column(name = "room_create_time")
    @CreationTimestamp
    private Date createTime;

    @Column(name = "room_upload_time")
    private Timestamp uploadTime;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<GuestBook> guestBooks = new ArrayList<GuestBook>();

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<RoomVisit> roomVisits = new ArrayList<RoomVisit>();

    protected Room() { }

    public Room(Long id, String roomNo, RoomCreator roomCreator) {
        this.id = id;
        this.roomNo = roomNo;
        this.roomCreator = roomCreator;
        this.uploadTime = new Timestamp(System.currentTimeMillis());
    }

    public void setRoomCount(Long roomCount) {
        this.roomCount += roomCount;
    }

}