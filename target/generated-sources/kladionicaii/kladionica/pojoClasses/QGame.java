package kladionicaii.kladionica.pojoClasses;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGame is a Querydsl query type for Game
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGame extends EntityPathBase<Game> {

    private static final long serialVersionUID = -663229954L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGame game = new QGame("game");

    public final StringPath designation = createString("designation");

    public final NumberPath<Integer> flag = createNumber("flag", Integer.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final QOperater operater;

    public final DateTimePath<java.time.LocalDateTime> time = createDateTime("time", java.time.LocalDateTime.class);

    public QGame(String variable) {
        this(Game.class, forVariable(variable), INITS);
    }

    public QGame(Path<? extends Game> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGame(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGame(PathMetadata metadata, PathInits inits) {
        this(Game.class, metadata, inits);
    }

    public QGame(Class<? extends Game> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.operater = inits.isInitialized("operater") ? new QOperater(forProperty("operater")) : null;
    }

}

