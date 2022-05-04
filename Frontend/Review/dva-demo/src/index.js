import dva from 'dva';
import './index.css';

// 1. Initialize
const app = dva({
  // history: require("history").createHashHistory()
});

// 2. Plugins
// app.use({});

// 3. Model
app.model(require("./models/film").default);

// 4. Router
app.router(require('./router').default);

// 5. Start
app.start('#root');
