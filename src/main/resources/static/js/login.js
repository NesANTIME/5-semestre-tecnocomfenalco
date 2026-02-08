// ========== VARIABLES GLOBALES ==========
// Usuarios de ejemplo (en producción esto estaría en un backend)
const users = [
    { username: 'admin', password: 'admin123' },
    { username: 'supervisor', password: 'super123' },
    { username: 'operador', password: 'oper123' }
];

// ========== INICIALIZACIÓN ==========
document.addEventListener('DOMContentLoaded', function() {
    const loginForm = document.getElementById('loginForm');
    
    if (loginForm) {
        loginForm.addEventListener('submit', handleLogin);
    }
    
    // Limpiar mensaje de error al escribir
    const usernameInput = document.getElementById('username');
    const passwordInput = document.getElementById('password');
    
    if (usernameInput) {
        usernameInput.addEventListener('input', clearError);
    }
    
    if (passwordInput) {
        passwordInput.addEventListener('input', clearError);
    }
});

// ========== FUNCIONES DE AUTENTICACIÓN ==========
function handleLogin(e) {
    e.preventDefault();
    
    const username = document.getElementById('username').value.trim();
    const password = document.getElementById('password').value;
    const errorMessage = document.getElementById('errorMessage');
    const submitButton = document.querySelector('.btn-login');
    
    // Mostrar estado de carga
    submitButton.disabled = true;
    submitButton.innerHTML = '<span>Verificando...</span>';
    
    // Simular delay de autenticación
    setTimeout(() => {
        // Verificar credenciales
        const user = users.find(u => u.username === username && u.password === password);
        
        if (user) {
            // Login exitoso
            errorMessage.textContent = '';
            errorMessage.style.color = '#4caf50';
            errorMessage.textContent = '✓ Inicio de sesión exitoso';
            
            // Animación de éxito
            submitButton.innerHTML = '<span>¡Bienvenido!</span> <i class="arrow">✓</i>';
            submitButton.style.background = 'linear-gradient(135deg, #4caf50 0%, #45a049 100%)';
            
            // Redirigir después de 1.5 segundos (aquí iría la redirección real)
            setTimeout(() => {
                alert(`¡Bienvenido ${username}!\n\nEn una aplicación real, ahora serías redirigido al dashboard.`);
                
                // Resetear formulario
                document.getElementById('loginForm').reset();
                errorMessage.textContent = '';
                submitButton.disabled = false;
                submitButton.innerHTML = '<span>Iniciar Sesión</span> <i class="arrow">→</i>';
                submitButton.style.background = '';
            }, 1500);
            
        } else {
            // Login fallido
            errorMessage.textContent = '⚠️ Usuario o contraseña incorrectos';
            errorMessage.style.color = '#f44336';
            document.getElementById('password').value = '';
            document.getElementById('password').focus();
            
            // Animación de error
            const loginBox = document.querySelector('.login-box');
            loginBox.style.animation = 'shake 0.5s';
            setTimeout(() => {
                loginBox.style.animation = '';
            }, 500);
            
            // Resetear botón
            submitButton.disabled = false;
            submitButton.innerHTML = '<span>Iniciar Sesión</span> <i class="arrow">→</i>';
        }
    }, 800);
}

function clearError() {
    const errorMessage = document.getElementById('errorMessage');
    if (errorMessage) {
        errorMessage.textContent = '';
    }
}

// Animación de shake para errores
const style = document.createElement('style');
style.textContent = `
    @keyframes shake {
        0%, 100% { transform: translateX(0); }
        10%, 30%, 50%, 70%, 90% { transform: translateX(-10px); }
        20%, 40%, 60%, 80% { transform: translateX(10px); }
    }
`;
document.head.appendChild(style);

// ========== CREDENCIALES DE PRUEBA ==========
console.log('=== CREDENCIALES DE PRUEBA ===');
console.log('Usuario: admin | Contraseña: admin123');
console.log('Usuario: supervisor | Contraseña: super123');
console.log('Usuario: operador | Contraseña: oper123');
console.log('==============================');