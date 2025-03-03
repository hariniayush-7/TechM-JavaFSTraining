const scheduleData = [
    {
        time: '09:00 - 10:00',
        title: 'Opening Keynote',
        speaker: 'Sarah Johnson',
        track: 'all',
        description: 'Welcome address and future of technology'
    },
    {
        time: '10:15 - 11:15',
        title: 'AI in Enterprise',
        speaker: 'Michael Chen',
        track: 'ai',
        description: 'Implementation of AI in enterprise solutions'
    },
    {
        time: '11:30 - 12:30',
        title: 'Modern Web Development',
        speaker: 'Emma Wilson',
        track: 'web',
        description: 'Latest trends in web development'
    },
    {
        time: '14:00 - 15:00',
        title: 'Cloud Architecture',
        speaker: 'David Kumar',
        track: 'cloud',
        description: 'Building scalable cloud solutions'
    }
];

function renderSchedule(track = 'all') {
    const scheduleGrid = document.getElementById('schedule-grid');
    const filteredSchedule = track === 'all' 
        ? scheduleData 
        : scheduleData.filter(item => item.track === track);

    scheduleGrid.innerHTML = filteredSchedule.map(item => `
        <div class="schedule-item">
            <div class="schedule-time">${item.time}</div>
            <div class="schedule-content">
                <h3>${item.title}</h3>
                <p>Speaker: ${item.speaker}</p>
                <p>${item.description}</p>
                <span class="schedule-track">${item.track.toUpperCase()}</span>
            </div>
        </div>
    `).join('');
}

// Initialize schedule and filters
document.addEventListener('DOMContentLoaded', () => {
    renderSchedule();

    const filterButtons = document.querySelectorAll('.filter-btn');
    filterButtons.forEach(button => {
        button.addEventListener('click', () => {
            // Update active state
            filterButtons.forEach(btn => btn.classList.remove('active'));
            button.classList.add('active');

            // Filter schedule
            renderSchedule(button.dataset.track);
        });
    });
});