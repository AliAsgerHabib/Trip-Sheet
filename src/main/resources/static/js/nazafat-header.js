class NazafatHeader extends HTMLElement {
  constructor() {
    super();
    const shadow = this.attachShadow({ mode: 'open' });

    shadow.innerHTML = `
      <style>
        :host {
          --gold: #BC872B;
          --background: #f4f4f4;
          --border: #dadada;
          --clock-color: #3c3c3c;
          --text-light: #1e1e1e;
        }

        #custom-header {
          background-color: var(--background);
          color: var(--text-light);
          padding: 20px 32px;
          display: flex;
          align-items: center;
          justify-content: space-between;
          font-family: 'Segoe UI', sans-serif;
          border-bottom: 1px solid var(--border);
          box-shadow: 0 2px 6px rgba(0, 0, 0, 0.05);
          position: sticky;
          top: 0;
          z-index: 1000;
        }

        .header-side {
          width: 200px;
          display: flex;
          align-items: center;
          justify-content: center;
        }

        .header-side:first-of-type {
          justify-content: flex-start; /* aligns logo to the left */
          padding-left: 10px; /* optional: adds a bit of breathing room */
        }


        .logo {
          height: 75px;
          width: 75px;
          border-radius: 6px;
          object-fit: cover;
          box-shadow: none;
        }

        .project-title {
          flex-grow: 1;
          text-align: center;
        }

        .project-title h2 {
          margin: 0;
          font-size: 36px;
          font-weight: 600;
          color: var(--gold);
          letter-spacing: 1px;
          text-transform: uppercase;
          text-shadow: 1px 1px 2px rgba(0,0,0,0.25);
        }

        .header-side.clock {
          justify-content: flex-end;
          padding-right: 10px; /* Optional: adds subtle spacing from edge */
        }

        .clock {
          font-size: 16px;
          font-weight: 600;
          text-align: right;
          color: var(--clock-color);
          line-height: 1.5;
        }
      </style>

      <div id="custom-header">
        <div class="header-side">
          <img src="images/logo.png" alt="Logo" class="logo">
        </div>
        <div class="project-title">
          <h2>Nazafat Status Dashboard</h2>
        </div>
        <div class="header-side clock" id="live-clock"></div>
      </div>
    `;

    this.startClock(shadow);
  }

  startClock(shadowRoot) {
    const clockEl = shadowRoot.getElementById('live-clock');

    function updateClock() {
      const now = new Date();
      const date = now.toLocaleDateString('en-IN', {
        weekday: 'short', year: 'numeric', month: 'short', day: 'numeric'
      });
      const time = now.toLocaleTimeString('en-IN', {
        hour: '2-digit', minute: '2-digit', second: '2-digit'
      });
      if (clockEl) clockEl.innerHTML = `${date}<br>${time}`;
    }

    updateClock();
    setInterval(updateClock, 1000);
  }
}

customElements.define('nazafat-header', NazafatHeader);