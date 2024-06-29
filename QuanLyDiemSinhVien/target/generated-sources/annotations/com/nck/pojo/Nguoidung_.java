package com.nck.pojo;

import com.nck.pojo.Dangkymonhoc;
import com.nck.pojo.Forums;
import com.nck.pojo.Lophoc;
import com.nck.pojo.Monhoc;
import com.nck.pojo.ScoreSv;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-06-27T23:42:57")
@StaticMetamodel(Nguoidung.class)
public class Nguoidung_ { 

    public static volatile SingularAttribute<Nguoidung, String> sdt;
    public static volatile SingularAttribute<Nguoidung, String> role;
    public static volatile SetAttribute<Nguoidung, Dangkymonhoc> dangkymonhocSet;
    public static volatile SetAttribute<Nguoidung, Monhoc> monhocSet;
    public static volatile SingularAttribute<Nguoidung, Boolean> active;
    public static volatile SingularAttribute<Nguoidung, String> avatar;
    public static volatile SetAttribute<Nguoidung, Lophoc> lophocSet;
    public static volatile SingularAttribute<Nguoidung, String> password;
    public static volatile SetAttribute<Nguoidung, ScoreSv> scoreSvSet;
    public static volatile SetAttribute<Nguoidung, Forums> forumsSet;
    public static volatile SingularAttribute<Nguoidung, Long> id;
    public static volatile SingularAttribute<Nguoidung, String> ten;
    public static volatile SingularAttribute<Nguoidung, String> email;
    public static volatile SingularAttribute<Nguoidung, String> username;

}