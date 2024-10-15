window.addEventListener('keydown', (event) => {
    switch (event.key) {
        case 'w':
        case 'ArrowUp':
            if (player.velocity.y === 0) {
                player.velocity.y = player.jumpSpeed
            }
            break
        case 'a':
        case 'ArrowLeft':
            keys.a.pressed = true
            break
        case 'd':
        case 'ArrowRight':
            keys.d.pressed = true
            break
    }
})

window.addEventListener('keyup', (event) => {
    switch (event.key) {
        case 'a':
        case 'ArrowLeft':
            keys.a.pressed = false
            break
        case 'd':
        case 'ArrowRight':
            keys.d.pressed = false
            break
    }
})
