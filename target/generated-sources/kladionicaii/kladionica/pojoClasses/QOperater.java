package kladionicaii.kladionica.pojoClasses;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QOperater is a Querydsl query type for Operater
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QOperater extends EntityPathBase<Operater> {

    private static final long serialVersionUID = -233054342L;

    public static final QOperater operater = new QOperater("operater");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public final StringPath pass = createString("pass");

    public QOperater(String variable) {
        super(Operater.class, forVariable(variable));
    }

    public QOperater(Path<? extends Operater> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOperater(PathMetadata metadata) {
        super(Operater.class, metadata);
    }

}

