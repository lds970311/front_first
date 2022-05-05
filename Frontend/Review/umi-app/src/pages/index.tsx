import styles from './index.less';
import {Redirect} from 'umi'


export default function IndexPage() {
  return (
    <div>
      <h1 className={styles.title}>Page index</h1>
      <Redirect to='cinema'/>
    </div>
  );
}
