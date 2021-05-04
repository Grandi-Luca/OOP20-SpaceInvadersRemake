package model.entities;

import model.entitiesutil.BossState;
import model.entitiesutil.Enemy;
import model.entitiesutil.Entity;
import model.entitiesutil.EntityDirections;
import model.physics.EntityCollision.EdgeCollision;
import model.physics.EntityMovementImpl;
import util.Pair;

/**
 * {@link Enemy} boss with a lot of life but that moves slowly
 */
public class Boss2 extends Enemy{

	private final int INITIAL_WIDTH = 0;
	private final int INITIAL_HEIGHT = 0;
	private final double INITIAL_MU_X = 0;
	private final double INITIAL_MU_Y = 0;
	private final int HITS_2ND_PHASE = 0;
	private final int MAX_HITS = 0;

	private BossState state;

	/**
	 * {@link Enemy} boss with a lot of life but that moves slowly
	 * 
	 * @param pos is the initial position of this entity
	 */
	public Boss2(Pair<Integer, Integer> pos) {
		this.create(EntityType.BOSS_2, pos, this.INITIAL_WIDTH, this.INITIAL_HEIGHT, this.INITIAL_MU_X, this.INITIAL_MU_Y,
				this.MAX_HITS, EntityDirections.DOWN, 
				new EntityMovementImpl());
		this.state = BossState.NORMAL;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void changeDirection() {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateEntityPos() {
		this.changeState();
		if(this.state.equals(BossState.UPSET)) {
			this.getMovementImpl().moveDown(this);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void shot() {
		/*this.model.getNewEntitiesLevel().add(new MultiDirectionsEnemyBullet(
				new Pair<>(this.getX() + this.getWidth()/4 - 1, this.getY() + this.getHeight()), 
				EntityType.BOSS_2_BULLET));
		this.model.getNewEntitiesLevel().add(new MultiDirectionsEnemyBullet(
				new Pair<>(this.getX() + this.getWidth()* 3/4 - 1,this.getY() + this.getHeight()), 
				EntityType.BOSS_2_BULLET));*/
	}

	/**
	 * Change the state of the boss after it took too many hits 
	 */
	private void changeState() {
		if(this.getHits() >= this.HITS_2ND_PHASE) {
			this.state = BossState.UPSET;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doAfterCollisionWith(Entity entity) {
		if(entity.getEntityType().equals(EntityType.PLAYER_BULLET) && this.isAlive()) {
			this.hit();
		}
		if(entity.getEntityType().equals(EntityType.PLAYER)) {
			//this.model.processGameOver();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doAfterCollisionWith(EdgeCollision edge) {
		if(edge.equals(EdgeCollision.DOWN)) {
			//this.model.processGameOver();
		}
	}
}
