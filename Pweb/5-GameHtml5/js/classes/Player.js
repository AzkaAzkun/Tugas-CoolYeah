class Player extends Sprite {
    constructor({ collisionBlock = [], imageSrc, frameRate, animations }) {
        super({ imageSrc, frameRate, animations })
        this.position = {
            x: 300,
            y: 300,
        }

        this.velocity = {
            x: 0,
            y: 0
        }

        this.sides = {
            bottom: this.position.y + this.height
        }

        this.gravity = 1.5 
        this.jumpSpeed = -20
        this.maxFallSpeed = 10
        this.collisionBlock = collisionBlock
    }

    update() {
        this.position.x += this.velocity.x

        this.hitbox = {
            position: {
                x: this.position.x + 58,
                y: this.position.y + 34,
            },
            width: 50,
            height: 53,
        }

        this.checkForHorizontalCollisions()
        this.applyGravity()

        this.hitbox = {
            position: {
                x: this.position.x + 58,
                y: this.position.y + 34,
            },
            width: 50,
            height: 53,
        }

        this.checkForVerticalCollisions()
    }

    switchSprite(name) {
        if (this.image === this.animations[name].image) return
        this.currentFrame = 0
        this.image = this.animations[name].image
        this.frameRate = this.animations[name].frameRate
        this.frameBuffer = this.animations[name].frameBuffer
    }

    checkForHorizontalCollisions() {
        for (let i = 0; i < this.collisionBlock.length; i++) {
            const collisionBlock = this.collisionBlock[i]
            if (
                this.hitbox.position.x <= collisionBlock.position.x + collisionBlock.width &&
                this.hitbox.position.x + this.hitbox.width >= collisionBlock.position.x &&
                this.hitbox.position.y + this.hitbox.height >= collisionBlock.position.y &&
                this.hitbox.position.y <= collisionBlock.position.y + collisionBlock.height
            ) {
                if (this.velocity.x < 0) {
                    const offset = this.position.x - this.hitbox.position.x
                    this.position.x = collisionBlock.position.x + collisionBlock.width + 0.01 + offset
                    break
                }
                if (this.velocity.x > 0) {
                    const offset = this.hitbox.position.x - this.position.x + this.hitbox.width
                    this.position.x = collisionBlock.position.x - offset - 0.01
                    break
                }
            }
        }
    }

    applyGravity() {
        if (this.velocity.y < this.maxFallSpeed) {
            this.velocity.y += this.gravity
        }
        this.position.y += this.velocity.y
    }

    checkForVerticalCollisions() {
        for (let i = 0; i < this.collisionBlock.length; i++) {
            const collisionBlock = this.collisionBlock[i]
            if (
                this.hitbox.position.x <= collisionBlock.position.x + collisionBlock.width &&
                this.hitbox.position.x + this.hitbox.width >= collisionBlock.position.x &&
                this.hitbox.position.y + this.hitbox.height >= collisionBlock.position.y &&
                this.hitbox.position.y <= collisionBlock.position.y + collisionBlock.height
            ) {
                if (this.velocity.y < 0) {
                    this.velocity.y = 0
                    const offset = this.hitbox.position.y - this.position.y
                    this.position.y = collisionBlock.position.y + collisionBlock.height - offset + 0.01
                    break
                }

                if (this.velocity.y > 0) {
                    this.velocity.y = 0
                    const offset = this.hitbox.position.y - this.position.y + this.hitbox.height
                    this.position.y = collisionBlock.position.y - offset - 0.01
                    break
                }
            }
        }
    }
}
