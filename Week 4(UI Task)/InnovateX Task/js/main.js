// Mobile Menu Toggle
const hamburger = document.querySelector('.hamburger');
const navLinks = document.querySelector('.nav-links');

hamburger.addEventListener('click', () => {
    navLinks.classList.toggle('active');
});

function updateCountdown() {
    const targetDate = new Date('2025-06-15T09:00:00').getTime();
    const now = new Date().getTime();
    const timeLeft = targetDate - now;

    const days = Math.floor(timeLeft / (1000 * 60 * 60 * 24));
    const hours = Math.floor((timeLeft % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
    const minutes = Math.floor((timeLeft % (1000 * 60 * 60)) / (1000 * 60));
    const seconds = Math.floor((timeLeft % (1000 * 60)) / 1000);

    document.getElementById('countdown').innerHTML = `
        <div class="countdown-container">
            <div class="countdown-item">
                <span class="countdown-number">${days}</span>
                <span class="countdown-label">Days</span>
            </div>
            <div class="countdown-item">
                <span class="countdown-number">${hours}</span>
                <span class="countdown-label">Hours</span>
            </div>
            <div class="countdown-item">
                <span class="countdown-number">${minutes}</span>
                <span class="countdown-label">Minutes</span>
            </div>
            <div class="countdown-item">
                <span class="countdown-number">${seconds}</span>
                <span class="countdown-label">Seconds</span>
            </div>
        </div>
    `;
}

setInterval(updateCountdown, 1000);
updateCountdown();



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