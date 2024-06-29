package com.nck.pojo;

import com.nck.pojo.Dangkymonhoc;
import com.nck.pojo.Forums;
import com.nck.pojo.Monhoc;
import com.nck.pojo.Nguoidung;
import com.nck.pojo.ScoreSv;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-06-27T23:42:57")
@StaticMetamodel(Lophoc.class)
public class Lophoc_ { 

    public static volatile SingularAttribute<Lophoc, Monhoc> monhoc;
    public static volatile SetAttribute<Lophoc, ScoreSv> scoreSvSet;
    public static volatile SetAttribute<Lophoc, Dangkymonhoc> dangkymonhocSet;
    public static volatile SetAttribute<Lophoc, Nguoidung> nguoidungSet;
    public static volatile SetAttribute<Lophoc, Forums> forumsSet;
    public static volatile SingularAttribute<Lophoc, Long> id;
    public static volatile SingularAttribute<Lophoc, String> ten;

}