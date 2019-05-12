package kladionicaii.kladionica.pojoClasses;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGameTicket is a Querydsl query type for GameTicket
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGameTicket extends EntityPathBase<GameTicket> {

    private static final long serialVersionUID = 14764714L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGameTicket gameTicket = new QGameTicket("gameTicket");

    public final QGame game;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Integer> prediction = createNumber("prediction", Integer.class);

    public final QTicket ticket;

    public QGameTicket(String variable) {
        this(GameTicket.class, forVariable(variable), INITS);
    }

    public QGameTicket(Path<? extends GameTicket> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGameTicket(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGameTicket(PathMetadata metadata, PathInits inits) {
        this(GameTicket.class, metadata, inits);
    }

    public QGameTicket(Class<? extends GameTicket> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.game = inits.isInitialized("game") ? new QGame(forProperty("game"), inits.get("game")) : null;
        this.ticket = inits.isInitialized("ticket") ? new QTicket(forProperty("ticket"), inits.get("ticket")) : null;
    }

}

