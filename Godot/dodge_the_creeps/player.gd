extends Area2D

# Emitir sinal para simular a colisão com um inimigo
signal hit

# Velocidade do player
@export var speed = 400
# Tamanho da tela
var screen_size

# Como se fosse o Create da LibGDX
func _ready():
	screen_size = get_viewport_rect().size
	#hide()

func start(pos):
	position = pos
	show()	
	$CollisionShape2D.disabled = false
	
# Como se fosse o Render da LibGDX	
func _process(delta):
	# Movimento do Player no Vector
	# Esta informação já é do NÓ/Objeto Player
	var velocity = Vector2.ZERO
	if Input.is_action_pressed("move_right"):
		velocity.x += 1
	if Input.is_action_pressed("move_left"):
		velocity.x -= 1
	if Input.is_action_pressed("move_down"):
		velocity.y += 1
	if Input.is_action_pressed("move_up"):
		velocity.y -= 1
		
	# Executando a animação
	if velocity.length() > 0:
		velocity = velocity.normalized() * speed
		$AnimatedSprite2D.play()
	else:
		$AnimatedSprite2D.stop()
		
	# Trocando a animação do Player
	if velocity.x != 0:
		$AnimatedSprite2D.animation = "walk"
		$AnimatedSprite2D.flip_v = false
		$AnimatedSprite2D.flip_h = velocity.x < 0
	elif velocity.y != 0:
		$AnimatedSprite2D.animation = "up"
		$AnimatedSprite2D.flip_v = velocity.y > 0
		
	# Modificação da posição do Player
	position += velocity * delta
	# Limitando a posição na tela
	position = position.clamp(Vector2.ZERO, screen_size)
	

# Trabalhando com a colisão que neste caso é um Node
func _on_body_entered(body):
	# Player será desaparecido após o hit
	hide()
	hit.emit()
	#O set_deferred aguarda para desabilitar a forma até for seguro
	$CollisionShape2D.set_deferred("disabled", true)
