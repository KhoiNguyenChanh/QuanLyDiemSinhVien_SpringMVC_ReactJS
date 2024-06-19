package com.nck.pojo;

import com.nck.pojo.Forums;
import com.nck.pojo.Nguoidung;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-06-17T23:21:19")
@StaticMetamodel(TinNhanForum.class)
public class TinNhanForum_ { 

    public static volatile SingularAttribute<TinNhanForum, Nguoidung> tacGiaId;
    public static volatile SingularAttribute<TinNhanForum, Long> id;
    public static volatile SingularAttribute<TinNhanForum, String> noiDung;
    public static volatile SingularAttribute<TinNhanForum, Date> thoiGian;
    public static volatile SingularAttribute<TinNhanForum, Forums> forumId;

}