import React from 'react';
import {connect} from 'dva';
import styles from './IndexPage.css';

function IndexPage(props) {
  console.log(props)

  function changeHide() {
    props.dispatch({
      type: 'film/hide'
    })
  }

  return (
    <div className={styles.normal}>
      <h1 className={styles.title}>Yay! Welcome to dva!</h1>
      <div className={styles.welcome}/>
      {/*<button onClick={changeHide}>hide</button>*/}
      {
        props.isShow ? (
          <ul className={styles.list}>
            <li>To get started, edit <code>src/index.js</code> and save to reload.</li>
            <li><a href="https://github.com/dvajs/dva-docs/blob/master/v1/en-us/getting-started.md">Getting Started</a>
            </li>
          </ul>
        ) : null
      }

    </div>
  );
}

IndexPage.propTypes = {};

export default connect(state => {
  return state.film
})(IndexPage);
