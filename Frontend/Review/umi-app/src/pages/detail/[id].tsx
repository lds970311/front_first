import React from 'react';
import {useParams} from 'umi'

const Detail = () => {
  const params = useParams()
  console.log(params)
  return (
    <div>
      details
    </div>
  );
};

export default Detail;
