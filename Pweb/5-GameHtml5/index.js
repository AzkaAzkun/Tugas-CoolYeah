const canvas = document.querySelector('canvas')
const c = canvas.getContext('2d')


canvas.width = window.innerWidth
canvas.height = window.innerHeight


const parsedCollisions = collisionsLevel1.parse2D()
const collisionBlock = parsedCollisions.createObjectsFrom2D()


const backgroundLevel1 = new Sprite({
    position: {
        x:0,
        y:0
    },
    imageSrc: './img/backgroundLevel1.png',
    scale: 1.5  
})

const player = new Player({
    collisionBlock,
    imageSrc: './img/king/idle.png',
    frameRate: 11,
    animations: {
        idleRight: {
            frameRate: 11,
            frameBuffer: 7,
            loop: true,
            imageSrc: './img/king/idle.png',
        },
        idleLeft: {
            frameRate: 11,
            frameBuffer: 7,
            loop: true,
            imageSrc: './img/king/idleLeft.png',
        },
        runRight: {
            frameRate: 8,
            frameBuffer: 7,
            loop: true,
            imageSrc: './img/king/runRight.png',
        },
        runLeft: {
            frameRate: 8,
            frameBuffer: 7,
            loop: true,
            imageSrc: './img/king/runLeft.png',
        },
    }
})

const keys = {
    w:{
        pressed: false
    },
    a:{
        pressed: false
    },
    d:{
        pressed: false
    },
}

function animate(){
    window.requestAnimationFrame(animate)

    c.fillStyle = 'white'
    c.fillRect(0,0,canvas.width,canvas.height)
    
    backgroundLevel1.draw()
    collisionBlock.forEach(collisionBlock => {
        collisionBlock.draw()
    })
    
    player.velocity.x = 0
    if (keys.d.pressed) {
        player.switchSprite('runRight')
        player.lastDirection = 'right'
        player.velocity.x = 4
    }
    else if (keys.a.pressed) {
        player.switchSprite('runLeft')
        player.lastDirection = 'left'
        player.velocity.x = -4
    } 
    else {
        if (player.lastDirection === 'left') player.switchSprite('idleLeft')
        else player.switchSprite('idleRight')
    }

    player.draw()
    player.update()
}

animate()
