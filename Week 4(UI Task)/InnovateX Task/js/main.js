/* Enhanced JavaScript for Mobile Interactions */
const hamburger = document.querySelector('.hamburger');
const navLinks = document.querySelector('.nav-links');
const body = document.querySelector('body');

// Toggle mobile menu
hamburger.addEventListener('click', () => {
    navLinks.classList.toggle('active');
    hamburger.classList.toggle('active');
    body.style.overflow = navLinks.classList.contains('active') ? 'hidden' : '';
});

// Close menu when clicking outside
document.addEventListener('click', (e) => {
    if (!hamburger.contains(e.target) && !navLinks.contains(e.target)) {
        navLinks.classList.remove('active');
        body.style.overflow = '';
    }
});

// Close menu on link click
navLinks.querySelectorAll('a').forEach(link => {
    link.addEventListener('click', () => {
        navLinks.classList.remove('active');
        body.style.overflow = '';
    });
});

// Smooth scroll for anchor links
const smoothScroll = (target, duration) => {
    const targetPosition = document.querySelector(target).offsetTop;
    const startPosition = window.scrollY;
    const distance = targetPosition - startPosition;
    let startTime = null;

    const animation = currentTime => {
        if (!startTime) startTime = currentTime;
        const timeElapsed = currentTime - startTime;
        const run = ease(timeElapsed, startPosition, distance, duration);
        window.scrollTo(0, run);
        if (timeElapsed < duration) requestAnimationFrame(animation);
    };

    const ease = (t, b, c, d) => -c * (t /= d) * (t - 2) + b;

    requestAnimationFrame(animation);
};

document.querySelectorAll('a[href^="#"]').forEach(anchor => {
    anchor.addEventListener('click', function (e) {
        e.preventDefault();
        smoothScroll(this.getAttribute('href'), 800);
    });
});

console.log('Mobile enhancements loaded successfully!');


document.querySelectorAll('a[href^="#"]').forEach(anchor => {
    anchor.addEventListener('click', function (e) {
        e.preventDefault();
        smoothScroll(this.getAttribute('href'), 800);
    });
});
// Countdown Timer
function updateCountdown() {
    const currentDate = new Date();
    const targetDate = new Date('2025-03-15T09:00:00');
    
    // Calculate the time remaining
    const totalSeconds = Math.floor((targetDate - currentDate) / 1000);
    
    if (totalSeconds > 0) {
        const days = Math.floor(totalSeconds / (24 * 60 * 60));
        const hours = Math.floor((totalSeconds % (24 * 60 * 60)) / (60 * 60));
        const minutes = Math.floor((totalSeconds % (60 * 60)) / 60);
        const seconds = Math.floor(totalSeconds % 60);

        const countdownElement = document.getElementById('countdown');
        if (countdownElement) {
            countdownElement.innerHTML = `
                <div class="countdown-container">
                    <div class="countdown-item">
                        <div class="countdown-number">${String(days).padStart(2, '0')}</div>
                        <div class="countdown-label">Days</div>
                    </div>
                    <div class="countdown-item">
                        <div class="countdown-number">${String(hours).padStart(2, '0')}</div>
                        <div class="countdown-label">Hours</div>
                    </div>
                    <div class="countdown-item">
                        <div class="countdown-number">${String(minutes).padStart(2, '0')}</div>
                        <div class="countdown-label">Minutes</div>
                    </div>
                    <div class="countdown-item">
                        <div class="countdown-number">${String(seconds).padStart(2, '0')}</div>
                        <div class="countdown-label">Seconds</div>
                    </div>
                </div>
            `;
        }
    }
}

// Initialize countdown only when element exists
document.addEventListener('DOMContentLoaded', function() {
    if (document.getElementById('countdown')) {
        updateCountdown();
        setInterval(updateCountdown, 1000);
    }
});

// Speakers Page Functionality
async function loadSpeakers() {
    try {
        const response = await fetch('/js/speakers.json');
        const data = await response.json();
        const speakersContainer = document.getElementById('speakers-grid');
        
        if (speakersContainer) {
            speakersContainer.innerHTML = data.speakers.map(speaker => `
                <div class="speaker-card">
                    <img src="${speaker.image}" alt="${speaker.name}">
                    <h3>${speaker.name}</h3>
                    <p class="speaker-title">${speaker.title}</p>
                    <p class="speaker-company">${speaker.company}</p>
                    <button onclick="showSpeakerDetails(${speaker.id})" class="speaker-details-btn">
                        View Details
                    </button>
                </div>
            `).join('');
        }
    } catch (error) {
        console.error('Error loading speakers:', error);
    }
}

// Contact Form Validation
function validateContactForm(event) {
    event.preventDefault();
    
    const name = document.getElementById('name');
    const email = document.getElementById('email');
    const message = document.getElementById('message');
    let isValid = true;

    // Reset error states
    clearErrors();

    // Name validation
    if (!name.value.trim()) {
        showError(name, 'Name is required');
        isValid = false;
    }

    // Email validation
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(email.value)) {
        showError(email, 'Please enter a valid email address');
        isValid = false;
    }

    // Message validation
    if (message.value.trim().length < 10) {
        showError(message, 'Message must be at least 10 characters long');
        isValid = false;
    }

    if (isValid) {
        // Here you would typically send the form data to a server
        alert('Thank you for your message! We will get back to you soon.');
        event.target.reset();
    }
}

function showError(element, message) {
    const errorDiv = document.createElement('div');
    errorDiv.className = 'error-message';
    errorDiv.textContent = message;
    element.parentNode.insertBefore(errorDiv, element.nextSibling);
    element.classList.add('error');
}

function clearErrors() {
    document.querySelectorAll('.error-message').forEach(error => error.remove());
    document.querySelectorAll('.error').forEach(element => element.classList.remove('error'));
}

// Initialize functionality
document.addEventListener('DOMContentLoaded', () => {
    // Load speakers if on speakers page
    if (window.location.pathname.includes('speakers.html')) {
        loadSpeakers();
    }

    // Setup contact form validation
    const contactForm = document.getElementById('contact-form');
    if (contactForm) {
        contactForm.addEventListener('submit', validateContactForm);
    }
});
// Add this to your existing main.js
document.addEventListener('DOMContentLoaded', function() {
    const registrationForm = document.getElementById('registration-form');
    if (registrationForm) {
        registrationForm.addEventListener('submit', function(e) {
            e.preventDefault();
                        // Create overlay and confirmation box
                        const overlay = document.createElement('div');
                        overlay.className = 'overlay';
                        
                        const confirmationBox = document.createElement('div');
                        confirmationBox.className = 'confirmation-box';
                        confirmationBox.innerHTML = `
                            <h3>Registration Successful!</h3>
                            <p>Thank you for registering for InnovateX. A confirmation email has been sent to your inbox.</p>
                            <button class="confirm-btn">Close</button>
                        `;
                        
                        document.body.appendChild(overlay);
                        document.body.appendChild(confirmationBox);
                        
                        overlay.style.display = 'block';
                        confirmationBox.style.display = 'block';
                        
                        // Handle close button
                        const closeBtn = confirmationBox.querySelector('.confirm-btn');
                        closeBtn.addEventListener('click', function() {
                            overlay.style.display = 'none';
                            confirmationBox.style.display = 'none';
                            registrationForm.reset();
                        });
                    });
                }
            });