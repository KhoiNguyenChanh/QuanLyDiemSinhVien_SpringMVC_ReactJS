package com.nck.pojo;

import com.nck.pojo.CotDiemThem;
import com.nck.pojo.Lophoc;
import com.nck.pojo.Nguoidung;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-06-27T23:42:57")
@StaticMetamodel(ScoreSv.class)
public class ScoreSv_ { 

    public static volatile SingularAttribute<ScoreSv, Lophoc> lophoc;
    public static volatile SetAttribute<ScoreSv, CotDiemThem> cotDiemThemSet;
    public static volatile SingularAttribute<ScoreSv, Nguoidung> nguoidung;
    public static volatile SingularAttribute<ScoreSv, Long> id;
    public static volatile SingularAttribute<ScoreSv, Double> giuaKy;
    public static volatile SingularAttribute<ScoreSv, Double> cuoiKy;

}