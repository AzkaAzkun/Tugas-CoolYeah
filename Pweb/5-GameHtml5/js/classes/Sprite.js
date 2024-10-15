class Sprite {
    constructor({position, imageSrc, frameRate = 1, animations, scale = 1 }) {
        this.position = position
        this.image = new Image()
        this.image.onload = () => {
            this.loaded = true
            this.width = (this.image.width / this.frameRate) * this.scale // Mengalikan dengan faktor skala
            this.height = this.image.height * this.scale
        }
        this.image.src = imageSrc
        this.loaded = false
        this.frameRate = frameRate
        this.currentFrame = 0
        this.elapsedFrames = 0
        this.frameBuffer = 7
        this.animations = animations
        this.scale = scale

        if (this.animations) {
            for (let key in this.animations) {
                const image = new Image()
                image.src = this.animations[key].imageSrc
                this.animations[key].image = image
            }
            console.log(this.animations)
        }
    }

    draw() {
        if (!this.loaded) return
        const cropbox = {
            position: {
                x: (this.image.width / this.frameRate) * this.currentFrame,
                y: 0,
            },
            width: this.image.width / this.frameRate,
            height: this.image.height
        }
        c.drawImage(
            this.image, 
            cropbox.position.x,
            cropbox.position.y,
            cropbox.width,
            cropbox.height,
            this.position.x, 
            this.position.y,
            cropbox.width * this.scale, // Memperbesar lebar sesuai skala
            cropbox.height * this.scale // Memperbesar tinggi sesuai skala
        )

        this.updateFrames()
    }

    updateFrames() {
        this.elapsedFrames++
        if (this.elapsedFrames % this.frameBuffer === 0){
            if (this.currentFrame < this.frameRate - 1) this.currentFrame++;
            else this.currentFrame = 0
        }
    }
}
