document.addEventListener('DOMContentLoaded', async () => {
    try {
        const response = await fetch('speakers.json');
        const data = await response.json();
        renderSpeakers(data.speakers);
        setupModal();
    } catch (error) {
        console.error('Error loading speakers:', error);
    }
});

function renderSpeakers(speakers) {
    const speakersGrid = document.getElementById('speakers-grid');
    
    speakersGrid.innerHTML = speakers.map(speaker => `
        <div class="speaker-card">
            <img src="${speaker.image}" alt="${speaker.name}" class="speaker-image">
            <div class="speaker-info">
                <h3>${speaker.name}</h3>
                <p class="speaker-title">${speaker.title}</p>
                <p class="speaker-company">${speaker.company}</p>
                <button class="speaker-details-btn" onclick="openSpeakerModal(${speaker.id})">
                    View Details
                </button>
            </div>
        </div>
    `).join('');
}

function openSpeakerModal(speakerId) {
    const modal = document.getElementById('speaker-modal');
    const modalContent = modal.querySelector('.speaker-details');
    
    fetch('speakers.json')
        .then(response => response.json())
        .then(data => {
            const speaker = data.speakers.find(s => s.id === speakerId);
            modalContent.innerHTML = `
                <div class="modal-speaker-content">
                    <img src="${speaker.image}" alt="${speaker.name}">
                    <h2>${speaker.name}</h2>
                    <h3>${speaker.title} at ${speaker.company}</h3>
                    <p class="speaker-topic">Topic: ${speaker.topic}</p>
                    <p class="speaker-bio">${speaker.bio}</p>
                </div>
            `;
            modal.style.display = 'block';
        });
}

function setupModal() {
    const modal = document.getElementById('speaker-modal');
    const closeBtn = document.querySelector('.close-modal');

    closeBtn.onclick = () => modal.style.display = 'none';
    window.onclick = (event) => {
        if (event.target === modal) {
            modal.style.display = 'none';
        }
    };
}